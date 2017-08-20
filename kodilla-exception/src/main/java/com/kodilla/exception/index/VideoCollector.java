package com.kodilla.exception.index;

import java.util.ArrayList;
import java.util.List;

final class VideoCollector {
    List<String> getCollection() {
        final ArrayList<String> videos = new ArrayList<>();
        videos.add("Extra Movie");
        return videos;
    }
}
