package com.agro.tech.fields.mensureshelter.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.agro.tech.fields.mensureshelter.exceptions.ExceptionBadRequest;
import com.agro.tech.fields.mensureshelter.exceptions.ExceptionNotFound;
import com.agro.tech.fields.mensureshelter.model.Foto;
import com.agro.tech.fields.mensureshelter.repository.FotoRepository;

@Service
public class FotoService {

  @Autowired
  private FotoRepository fotoRepo;

  public Foto inserirFoto(MultipartFile imagem) throws IOException {
    if (imagem.isEmpty())
      throw new ExceptionBadRequest("Selecione um arquivo de imagem.");
    String nomeDaImagem = imagem.getOriginalFilename();
    Foto novaFoto = new Foto();
    novaFoto.setNome(nomeDaImagem);
    novaFoto.setDataDeCriacao(LocalDate.now());
    novaFoto.setConteudo(new Binary(imagem.getBytes()));
    novaFoto.setTipoDeConteudo(imagem.getContentType());
    novaFoto.setTamanho(imagem.getSize());

    LocalDate dataDeCriacao = novaFoto.getDataDeCriacao();

    if (checarData(dataDeCriacao) == false) { throw new ExceptionBadRequest("Aguarde o período de 20 dias para inserir novas fotos");}
    
    return fotoRepo.insert(novaFoto);
  }

  public List<Foto> listarFotos() {
    return fotoRepo.findAll();
  }

  public byte[] baixarFoto(String id) {
    Foto foto =
        fotoRepo.findById(id).orElseThrow(() -> new ExceptionNotFound("Foto não encontrada."));
    return foto.getConteudo().getData();
  }

  public String deletarFotos(){
    fotoRepo.deleteAll();
    return "As fotos foram deletedas";
  }

  public boolean checarData(LocalDate dataDeCriacao) {

    List<Foto> listaDeFotos = fotoRepo.findAll(Sort.by(Sort.Direction.DESC, "dataDeCriacao"));
    if(listaDeFotos.size() < 1) return true;

    Foto fotoMaisRecente = listaDeFotos.get(0);
    int periodoMinimo = 20;
    int periodo = Period.between(fotoMaisRecente.getDataDeCriacao(), dataDeCriacao).getDays();
    if(fotoMaisRecente.getDataDeCriacao().equals(dataDeCriacao) || periodo >= periodoMinimo){
      return true;
    }
    
    return false;
  }

}
