package io.github.alexandresneto.nightcrawler.controller;

import io.github.alexandresneto.nightcrawler.domain.ClipboardInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/change")
@Slf4j
public class ClipboardChangeController {

    private Map<String, ClipboardInfo> database = new HashMap<>();

    @PostMapping
    public void register(@RequestBody ClipboardInfo info) {
        log.info("Clipboard Server :: New content register: {}", info);

        database.put(info.getUsername(), info);
    }

    @GetMapping("/{username}/{hostname}")
    public ClipboardInfo get(@PathVariable("username") String username, @PathVariable("hostname") String hostname) {
        log.info("Clipboard Server :: Getting content with username '{}' from hostname '{}'", username, hostname);

        ClipboardInfo clipboardInfo = database.get(username);
        if (clipboardInfo != null && !clipboardInfo.getHostname().equals(hostname)) {
            database.remove(username);
            log.info("Clipboard Server :: New content founded for: {}", clipboardInfo.getUsername());
            return clipboardInfo;
        }

        return null;
    }

}
