package io.github.alexandresneto.nightcrawler.controller;

import io.github.alexandresneto.nightcrawler.domain.ClipboardInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/clipboard")
@Slf4j
public class ClipboardChangeController {

    private Map<String, ClipboardInfo> database = new HashMap<>();

    @PostMapping
    public void register(ClipboardInfo info) {
        log.info("Registrando alterações {}", info);

        database.put(info.getHostname(), info);
    }

    @GetMapping("/{hostname}")
    public ClipboardInfo get(@PathVariable("hostname") String hostname) {
        log.info("Buscando alterações para o host {}", hostname);

        return database.get(hostname);
    }

}
