package com.example.background;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import javax.servlet.ServletContext;

public class ReportGeneratorTask extends TimerTask {

    private final ServletContext context;

    public ReportGeneratorTask(ServletContext context) {
        this.context = context;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        List<String> reports = (List<String>) context.getAttribute("reports");
        if (reports == null) {
            reports = new ArrayList<>();
            context.setAttribute("reports", reports);
        }
        String report = "Report generated at " + new Date();
        reports.add(report);
        System.out.println(report);
    }
}
