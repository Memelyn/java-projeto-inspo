package br.com.erudio.java_springboot_erudio.file.importer.contract;

import br.com.erudio.java_springboot_erudio.data.dto.PersonDTO;

import java.io.InputStream;
import java.util.List;

public interface FileImporter {

    List<PersonDTO> importFile(InputStream inputStream) throws Exception;
}
