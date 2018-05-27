package ch.logixisland.anuto.data.map;

import android.content.res.Resources;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Root
public class MapDescriptor {

    @Element(name = "id", required = false)
    private String mId;

    @Element(name = "width")
    private int mWidth;

    @Element(name = "height")
    private int mHeight;

    @ElementList(name = "plateaus", entry = "plateau")
    private List<PlateauDescriptor> mPlateaus = new ArrayList<>();

    @ElementList(name = "paths", entry = "path")
    private List<PathDescriptor> mPaths = new ArrayList<>();

    public static MapDescriptor fromXml(Serializer serializer, Resources resources, int resId, String mapId) throws Exception {
        InputStream stream = resources.openRawResource(resId);

        try {
            MapDescriptor mapDescriptor = serializer.read(MapDescriptor.class, stream);
            mapDescriptor.mId = mapId;
            return mapDescriptor;
        } finally {
            stream.close();
        }
    }

    public String getId() {
        return mId;
    }

    public int getHeight() {
        return mHeight;
    }

    public int getWidth() {
        return mWidth;
    }

    public Collection<PlateauDescriptor> getPlateaus() {
        return Collections.unmodifiableCollection(mPlateaus);
    }

    public List<PathDescriptor> getPaths() {
        return Collections.unmodifiableList(mPaths);
    }
}
