package com.ultraon.clamp.parser;

import com.ultraon.clamp.parser.model.Clamp;
import com.ultraon.clamp.parser.xml.DateFormatTransformer;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by vitaliypopov on 10.11.14.
 */
public class ParseEngine {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private String filePath;
    private String dirPath;

    private ISaver<Clamp> saver = new ClampSaver();

    public ParseEngine(@Nonnull String filePath, @Nullable final String targetDirPath) {
        this.filePath = filePath;
        this.dirPath = targetDirPath;
    }

    public void execute() throws Exception {
        final Serializer serializer = getSerializer();
        final Clamp clamp = serializer.read(Clamp.class, new File(filePath));
        saver.save(clamp, dirPath);
    }

    private Serializer getSerializer() {
        DateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.US);
        RegistryMatcher m = new RegistryMatcher();
        m.bind(Date.class, new DateFormatTransformer(format));
        return new Persister(m);
    }
}
