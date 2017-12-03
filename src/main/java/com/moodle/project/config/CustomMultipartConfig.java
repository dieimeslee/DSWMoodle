package com.moodle.project.config;

import br.com.caelum.vraptor.observer.upload.DefaultMultipartConfig;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@ApplicationScoped
@Specializes
public class CustomMultipartConfig extends DefaultMultipartConfig {

	@Override
	public long getSizeLimit() {
		return 50 * 1024 * 1024;
	}

}