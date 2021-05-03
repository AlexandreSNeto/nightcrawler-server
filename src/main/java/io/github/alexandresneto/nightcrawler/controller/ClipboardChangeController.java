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
    public void register(@RequestBody ClipboardInfo info) {
        log.info("Registrando alterações {}", info);

        database.put(info.getUsername(), info);
    }

    @GetMapping("/{username}/{hostname}")
    public ClipboardInfo get(@PathVariable("username") String username, @PathVariable("hostname") String hostname) {
        log.info("Buscando alterações para o usuario {} a partir do hostname {} ", username, hostname);

        ClipboardInfo clipboardInfo = database.get(username);
        if (clipboardInfo != null && !clipboardInfo.getHostname().equals(hostname)) {
            database.remove(username);
            return clipboardInfo;
        }

        return null;
    }

}
