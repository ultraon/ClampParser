package com.ultraon.clamp.parser;

import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.ultraon.clamp.parser.model.Clamp;
import com.ultraon.clamp.parser.model.Reading;
import com.ultraon.clamp.parser.model.Scan;

import java.io.*;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vitaliypopov on 11.11.14.
 */
public class ClampSaver {
    private static final String[] DARK_LIGHT_HEADERS = {"DarkScan (Wavelengths)", "DarkScan (Absorbances)",
            "LightScan (Wavelengths)", "LightScan (Absorbances)"};
    private static final String[] HEADERS = {"SpectrumScan (Wavelengths)", "SpectrumScan (Absorbances)"};
    private static final String TMP_PATH = "/tmp";

    private String externalDir;
    
    public void save(final Clamp model, final String dirPath) throws IOException {
        if (!FileUtils.isExistDir(dirPath)) {
            throw new IOException("Catalog already exists, remove catalog first");
        }
        
        externalDir = new File("").getAbsolutePath() + TMP_PATH;
        final String clampPath = externalDir + model.getId() + "_" + model.getName();

        FileUtils.mkdir(clampPath);

        List<Reading> readings = FluentIterable.from(model.getReadings()).filter(Predicates.notNull())
                .toSortedList(new Comparator<Reading>() {
                    @Override
                    public int compare(Reading o1, Reading o2) {
                        return o1.getCreated().compareTo(o2.getCreated());
                    }
                });

        for (Reading reading : readings) {
            saveReading(clampPath, reading);
        }
        
    }

    private void saveReading(final String dirPath, final Reading reading) throws IOException {
        String readingPath = dirPath + "/" + reading.getId();

        List<Scan> scans = FluentIterable.from(reading.getScans()).filter(Predicates.notNull()).toSortedList(new Comparator<Scan>() {
            @Override
            public int compare(Scan o1, Scan o2) {
                return 0;
            }
        });

        Writer writer = new BufferedWriter(new FileWriter(readingPath));

        //TODO stopped here, need save data with appropriate format
    }
}
