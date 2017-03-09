package com.tale.plugins.cms;

import com.blade.jdbc.model.Paginator;
import com.tale.dto.MetaDto;
import com.tale.dto.Types;
import com.tale.model.Contents;
import com.tale.service.ContentsService;
import com.tale.service.MetasService;

public class CMSTheme {
	private static ContentsService contentsService;
	private static MetasService metasService;

	public static void setContentsService(ContentsService contentsService) {
		CMSTheme.contentsService = contentsService;
	}

	public static void setMetasService(MetasService metasService) {
		CMSTheme.metasService = metasService;
	}
	
	
	
	public static Paginator<Contents> articles(String category, int page, int limit) {
		MetaDto metaDto = metasService.getMeta(Types.CATEGORY, category);
		if (null == metaDto) {
			return null;
		}
		Paginator<Contents> contentsPaginator = contentsService.getArticles(metaDto.getMid(), page, limit);
		return contentsPaginator;
	}
}
