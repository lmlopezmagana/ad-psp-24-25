package com.salesianostriana.dam.upload.files.utils;

import org.springframework.core.io.Resource;


public interface MimeTypeDetector {

    String getMimeType(Resource resource);

}
