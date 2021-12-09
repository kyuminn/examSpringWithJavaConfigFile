package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import member.dao.MemberDao;
import member.service.ChangePasswordService;
import member.service.MemberRegisterService;

@Configuration
@ImportResource("classpath:appctx.xml")
public class ConfigPartMain2_withXml {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		return new ChangePasswordService(memberDao());
	}
	
// appctx.xml로 나눠질 내용
//	@Bean
//	public MemberPrinter printer() {
//		return new MemberPrinter();
//	}
//	
//	@Bean
//	public MemberListPrinter listPrinter() {
//		return new MemberListPrinter(memberDao(), printer());
//	}
//	
//	@Bean
//	public MemberInfoPrinter infoPrinter() {
//		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setMemberPrinter(printer());
//		return infoPrinter;
//		
//	}
//	
//	@Bean
//	public VersionPrinter versionPrinter() {
//		VersionPrinter versionPrinter = new VersionPrinter();
//		versionPrinter.setMajorVersion(4);
//		versionPrinter.setMinorVersion(1);
//		return versionPrinter;
//	}
	
	
}
