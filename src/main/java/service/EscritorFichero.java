package service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;

public class EscritorFichero {
    public void escribirFichero(String rutaDirectorio, String ciudad, List<String> datos) throws IOException {
        LocalDate ld = LocalDate.now();
        Path filePath = Paths.get(rutaDirectorio + File.separator + ciudad + "-" + ld.getDayOfMonth() + "-" + ld.getMonth() + "-" + ld.getYear()+ ".html");
        Files.createFile(filePath);
        //Con esta opción se sobreescribirá el documento si hay otro llamado igual
        Files.write(filePath, datos, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }
}
