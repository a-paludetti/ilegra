package br.com.desafio.ilegra.api.factories;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Log4j2
public class ReadFile implements Runnable {

    public final String IN = "./data/in/";
    public final String OUT = "./data/out/";

    @Override
    public void run() {
        try {
            verifyFile();
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            log.error("Erro ao colocar um timer de 10s. {}", e.getMessage());
        }
    }

    private void verifyFile() {
        try {
            Stream<Path> stream = Files.walk(Paths.get(IN));
            stream.sorted(Comparator.comparing(Path::getFileName)).forEach(file -> {
                processFile(file.toAbsolutePath());
                outFile(file.toAbsolutePath());
            });
        } catch (IOException e) {
            log.info("Nenhum arquivo encontrado");
        }
    }

    private void outFile(Path file) {
    }

    private void processFile(Path path) {
        new FileProcessor().process(path.toFile());
    }

    public void verifyFolders(){
        List<String> list = Arrays.asList(IN, OUT);

        list.forEach(s -> {
            File file = new File(s);

            if(!file.exists()){
                file.mkdirs();
                log.info("Criado pasta: {}", s);
            }
        });
    }
}
