package com.sofka.retofinal.usecase;


import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.KrRepository;
import com.sofka.retofinal.repository.OkrRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
@Validated
public class CreateOkr {

    private final OkrRepository okrRepository;
    private final KrRepository krRepository;
    private final MapperUtils mapperUtils;


    public CreateOkr(OkrRepository okrRepository, KrRepository krRepository, MapperUtils mapperUtils) {
        this.okrRepository = okrRepository;
        this.krRepository = krRepository;
        this.mapperUtils = mapperUtils;

    }

    public Mono<String> apply(@Valid OkrDTO okrDTO) {
        return okrRepository.save(mapperUtils.okrDTOToOkrEntity().apply(okrDTO))
                .flatMap(okr -> {
                    var tamaño =okrDTO.getKrs().size() ;
                    var range = IntStream.range(0,tamaño );

                    var totalWeight = range.reduce(0, (acc, s2) ->
                            (acc + okrDTO.getKrs().get(s2).getPercentageWeight()));

                    return     Optional.of(totalWeight).filter(tw -> tw.equals(100)).map(t -> {
                        okrDTO.getKrs().forEach(kr -> kr.setOkrId(okr.getId()));
                        krRepository.saveAll(mapperUtils.listKrDtoToListKrEntity().apply(okrDTO.getKrs()))
                                .subscribe();
                        return Mono.just(okr.getId());
                    }).orElseThrow(() -> new IllegalArgumentException("el total de pesos % debe ser igual a 100%"));

                });
    }



}
