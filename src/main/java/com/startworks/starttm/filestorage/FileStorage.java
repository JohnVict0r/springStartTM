package com.startworks.starttm.filestorage;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
 
@Component
public class FileStorage{
	
	@Value("${starttm.disco.raiz}")
	private String raiz;
	
	@Value("${starttm.disco.diretorio-eventos}")
	private String diretorioEventos;
	
	@Value("${starttm.disco.evento.circular}")
	private String diretorioCircular;
	
	@Value("${starttm.disco.evento.imagem}")
	private String diretorioImagem;
	
	public void salvarCircular(MultipartFile file) {
		
		String diretorio=this.diretorioEventos + this.diretorioCircular;		
		this.salvar(diretorio, file);		
	}
 
	public void salvarImagem(MultipartFile file) {
		
		String diretorio=this.diretorioEventos + this.diretorioImagem;		
		this.salvar(diretorio, file);		
	}
	
	public void salvar(String diretorio, MultipartFile file){
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(file.getOriginalFilename());
			
		try {			            
            file.transferTo(arquivoPath.toFile());             
        } catch (Exception e) {
        	throw new RuntimeException("Problemas ao salvar o arquivo: "+file.getOriginalFilename());
        }
	}		
	
	public String getLocalArquivo(Path rootLocation ,MultipartFile file) {
		
		Path diretorioPath = Paths.get(this.raiz, this.diretorioEventos);
		Path arquivoPath = diretorioPath.resolve(file.getOriginalFilename());
		
		return arquivoPath.toString();
		
	}
	
	public Boolean validarArquivo(MultipartFile arquivo) {
		
		
		if(arquivo.getContentType().equalsIgnoreCase("application/pdf") && !arquivo.isEmpty()	) {			
			return true;
		}
		
		return false;
	}
	
	public Boolean validarImagem(MultipartFile imagem) {
				
		if((imagem.getContentType().equalsIgnoreCase("image/png") ||
				imagem.getContentType().equalsIgnoreCase("image/jpeg") ) && !imagem.isEmpty()) {			
			return true;
		}
		
		return false;
	}
}


