package com.startworks.starttm.filestorage;

import java.nio.file.Files;
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
	
	
	public void salvar(Path rootLocation, MultipartFile file){					
		try {
            Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));                            
        } catch (Exception e) {
        	throw new RuntimeException("Problemas ao salvar o arquivo: "+file.getOriginalFilename());
        }
	}
	
	public String getLocalArquivo(Path rootLocation ,MultipartFile file) {
		
		Path diretorioPath = Paths.get(this.raiz, this.diretorioEventos);
		Path arquivoPath = diretorioPath.resolve(file.getOriginalFilename());
		
		return arquivoPath.toString();
		
	}
}
