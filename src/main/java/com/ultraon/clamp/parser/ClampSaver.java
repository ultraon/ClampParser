package com.ultraon.clamp.parser;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

import com.ultraon.clamp.parser.model.Clamp;
import com.ultraon.clamp.parser.model.Reading;
import com.ultraon.clamp.parser.model.Scan;

import javax.annotation.Nullable;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vitaliypopov on 11.11.14.
 */
public class ClampSaver implements ISaver<Clamp> {
    private static final String[] DARK_LIGHT_HEADERS = {"DarkScan (Wavelengths)", "DarkScan (Absorbances)",
            "LightScan (Wavelengths)", "LightScan (Absorbances)"};
    private static final String[] HEADERS = {"SpectrumScan (Wavelengths)", "SpectrumScan (Absorbances)"};
    private static final String TMP_PATH = "/tmp";

    private String externalDir;
    
    @Override
    public void save(final Clamp model, final String dirPath) throws IOException {
        if (Strings.isNullOrEmpty(dirPath)) {
            externalDir = new File("").getAbsolutePath() + TMP_PATH;
        } else {
            externalDir = dirPath;
        }

        final String clampPath = externalDir + "/" + model.getId() + "_" + model.getName();

        if (FileUtils.isExistDir(clampPath)) {
            String message = "Catalog already exists, removing: " + clampPath;
//            throw new IOException(message);
            System.out.println(message);
            FileUtils.deleteDirectory(clampPath);
        }

        FileUtils.mkdir(clampPath);

        List<Reading> readings = FluentIterable.from(model.getReadings()).filter(Predicates.notNull())
                .toSortedList(new Comparator<Reading>() {
                    @Override
                    public int compare(Reading o1, Reading o2) {
                        return o1.getCreated().compareTo(o2.getCreated());
                    }
                });

        int count = 0;
        for (Reading reading : readings) {
            saveReading(clampPath, String.format("%03d_", count++), reading);
        }
        
    }

    private void saveReading(final String dirPath, final String prefix, final Reading reading) throws IOException {
        String readingPath = dirPath + "/" + prefix + reading.getId() + ".csv";

        List<Scan> mainScans = FluentIterable.from(reading.getScans()).filter(Predicates.notNull()).filter(new Predicate<Scan>() {
            @Override
            public boolean apply(@Nullable Scan scan) {
                return "main".equalsIgnoreCase(scan.getType());
            }
        }).toList();

        Scan blackScan = getScanByType("black", reading.getScans());
        if (null == blackScan) throw new IllegalArgumentException("xml file doesn't have black scan for reading id=" + reading.getId());

        Scan whiteScan = getScanByType("white", reading.getScans());
        if (null == whiteScan) throw new IllegalArgumentException("xml file doesn't have white scan for reading id=" + reading.getId());
        ArrayList<Scan> scans = Lists.newArrayList(blackScan, whiteScan);
        scans.addAll(mainScans);
        Writer writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(readingPath));
            writeData(writer, scans);
        } finally {
            if (null != writer) writer.close();
        }
    }

    private void writeData(final Writer writer, final List<Scan> orderedScans) throws IOException {
        //black, white, main...
        for (Scan scan : orderedScans) {
            if ("black".equalsIgnoreCase(scan.getType())) {
                writer.write(DARK_LIGHT_HEADERS[0] + ",," + scan.getWavelengths() + "\n");
                writer.write(DARK_LIGHT_HEADERS[1] + ",," + scan.getAbsorbances() + "\n");
            } else if ("white".equalsIgnoreCase(scan.getType())) {
                writer.write(DARK_LIGHT_HEADERS[2] + ",," + scan.getWavelengths() + "\n");
                writer.write(DARK_LIGHT_HEADERS[3] + ",," + scan.getAbsorbances() + "\n");
            } else {
                writer.write(HEADERS[0] + ",0," + scan.getWavelengths() + "\n");
                writer.write(HEADERS[1] + ",0," + scan.getAbsorbances() + "\n");
            }
        }
    }

    private Scan getScanByType(final String type, final List<Scan> scans) {
        return FluentIterable.from(scans).firstMatch(new Predicate<Scan>() {
            @Override
            public boolean apply(@Nullable Scan scan) {
                return type.equalsIgnoreCase(scan.getType());
            }
        }).orNull();
    }
}
