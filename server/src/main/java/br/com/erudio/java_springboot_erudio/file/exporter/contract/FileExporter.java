package br.com.erudio.java_springboot_erudio.file.exporter.contract;

import br.com.erudio.java_springboot_erudio.data.dto.PersonDTO;
import org.springframework.core.io.Resource;

import java.util.List;

public interface FileExporter {

    Resource exportFile(List<PersonDTO> people) throws Exception;
}
