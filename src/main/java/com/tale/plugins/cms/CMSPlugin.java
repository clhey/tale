package com.tale.plugins.cms;

import javax.servlet.ServletContext;

import com.blade.annotation.Order;
import com.blade.config.BConfig;
import com.blade.context.WebContextListener;
import com.blade.ioc.BeanProcessor;
import com.blade.ioc.Ioc;
import com.blade.mvc.view.ViewSettings;
import com.blade.mvc.view.template.JetbrickTemplateEngine;
import com.tale.service.ContentsService;
import com.tale.service.MetasService;

import jetbrick.template.resolver.GlobalResolver;

@Order(sort = 1)
public class CMSPlugin implements BeanProcessor, WebContextListener {

	@Override
	public void init(BConfig arg0, ServletContext arg1) {
		JetbrickTemplateEngine templateEngine = (JetbrickTemplateEngine) ViewSettings.$().templateEngine();
		GlobalResolver resolver = templateEngine.getGlobalResolver();
		resolver.registerFunctions(CMSTheme.class);
	}

	@Override
	public void register(Ioc ioc) {
		CMSTheme.setContentsService(ioc.getBean(ContentsService.class));
		CMSTheme.setMetasService(ioc.getBean(MetasService.class));
	}
}
