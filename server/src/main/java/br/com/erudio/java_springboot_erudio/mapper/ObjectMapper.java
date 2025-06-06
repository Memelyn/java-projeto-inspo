package br.com.erudio.java_springboot_erudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    // mapeia entidade para dto e vice versa

    public static <O, D> D parseObject(O origin, Class<D> destination) {
// exemplo: recebe um o do tipo person e converte para PersonDTO.class
        // mapeia objeto de origem para objeto de destino
        return mapper.map(origin, destination);
    }
    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
// mapeia objeto de origem para objeto de destino

        // aqui é a mesma coisa, mas com um alista, entã precisamos iterar
        //pela lista, criar um lista temporaria para retornar
        List<D> destinationObjects = new ArrayList<D>();
        // cria uma lista de objetos convertidos e itera sobre os objetos originais
        for (Object o : origin){
            // converta um a um para o destino
            destinationObjects.add(mapper.map(o, destination));
        }
        // devolve a lista
        return destinationObjects;
    }
}
