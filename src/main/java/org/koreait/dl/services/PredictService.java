package org.koreait.dl.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Lazy
@Service
@Profile("dl")
public class PredictService {
    @Value("${python.run.path}")
    private String runPath;

    @Value("${python.script.path}")
    private String scriptPath;

    @Value("${python.data.url}")
    private String dataUrl;

    @Autowired
    private ObjectMapper om;

    @PostConstruct
    public void init() {
        System.out.println("runPath: " + runPath);
        System.out.println("scriptPath: " + scriptPath);
        System.out.println("dataUrl: " + dataUrl);
        System.out.println("ObjectMapper injected: " + (om != null));
    }

    public int[] predict(List<int[]> items) {
        try {
            String data = om.writeValueAsString(items);

            ProcessBuilder builder = new ProcessBuilder(runPath, scriptPath + "predict.py", dataUrl + "?mode=ALL", data);
            Process process = builder.start();
            InputStream in = process.getInputStream();
            return om.readValue(in.readAllBytes(), int[].class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
