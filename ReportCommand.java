package com.company;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command{
    private Configuration cfg;

    public ReportCommand(Catalog catalog, Configuration cfg) {
        super(catalog);
        this.cfg = cfg;
    }

    @Override
    public void Execute() {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("title", catalog.getName());
        input.put("items", catalog.getItems());

        try {
            Writer fileWriter = new FileWriter(new File("output.html"));
            Template template = cfg.getTemplate("template.ftl");
            template.process(input, fileWriter);
            fileWriter.close();
            Desktop desktop = Desktop.getDesktop();
            File file = new File("output.html");
            if(file.exists()) {
                desktop.open(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
