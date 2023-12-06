package com.system.fridges.service.utils;


public class DatabaseManager {

    private static final String username = "root";

    private static final String password = "Pavlo1212004";

    private static final String databaseUrl = "jdbc:mysql://localhost:3306/control_fridges";


    public boolean backupSuccessful(String backupPath) {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump",
                "-u", username,
                "-p" + password,
                "--add-drop-table",
                "--databases", databaseUrl,
                "-r", backupPath
        );

        return createProcessSuccessful(processBuilder);
    }

    public boolean restoreSuccessful(String backupPath) {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql",
                "-u" + username,
                "-p" + password,
                databaseUrl,
                "-e", "source " + backupPath
        );

        return createProcessSuccessful(processBuilder);
    }

    private boolean createProcessSuccessful(ProcessBuilder processBuilder) {
        try {
            Process process = processBuilder.start();
            int processComplete = process.waitFor();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
