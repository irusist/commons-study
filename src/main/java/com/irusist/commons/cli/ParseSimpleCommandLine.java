package com.irusist.commons.cli;

import org.apache.commons.cli.*;

/**
 * Option helpOption = new Option("h", "Prints this usage information");
 * helpOption.setLongOpt("help");
 * options.addOption(helpOption);
 * 与options.addOption("h", "help", false, "Print this usage information");
 * 功能一样，其中第一个参数是简短名称，第二个参数是长名称，第三个参数说明需要不需要参数，
 * 第四个参数是描述说明
 *  CommandLine commandLine = new BasicParser().parse(Options, String[])
 *  commandLine.hasOption('h')
 *  commandLine.getOptionValue('f')
 *  这里可以指定 -h(--help) -v(--verbose) -f(--file) file.text
 * @author zhulixin
 */
public class ParseSimpleCommandLine {

    public static void main(String[] args) {
        // 创建Parser
        CommandLineParser parser = new BasicParser();
        Options options = new Options();
//        Option helpOption = new Option("h", "Prints this usage information");
//        helpOption.setLongOpt("help");
//        options.addOption(helpOption);
        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("v", "verbose", false, "Print out VERBOSE information");
        options.addOption("f", "file", true, "File to save program output to");

        // 解析程序参数
        CommandLine commandLine = null;
        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean verbose = false;
        String file = "";

        if (commandLine.hasOption('h')) {
            System.out.println("Help Message");
            System.exit(0);
        }

        if (commandLine.hasOption('v')) {
            verbose = true;
        }

        if (commandLine.hasOption('f')) {
            file = commandLine.getOptionValue('f');
        }
    }
}
