package project;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
public class Bootstrap {
    public static void main(String[] args) throws IOException {
        String fileName = "config.property";
        HashMap<String, Object> props = new HashMap<>();
        ArrayList<String[]> list = new ArrayList<>();
        Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).forEach(a->list.add(a.split("=")));
        HashMap<String,String> listToMap = new HashMap<>();
        list.stream().forEach(a -> listToMap.put(a[0],a[1]));

        props.put("server.port", listToMap.get("http.port"));

        new SpringApplicationBuilder()
                .sources(Bootstrap.class)
                .properties(props)
                .run(args);
    }


}
