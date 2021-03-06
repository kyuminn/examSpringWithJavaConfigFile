package member.printer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberListPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;
	
	public MemberListPrinter(MemberDao memberDao,MemberPrinter memberPrinter) {
		this.memberDao= memberDao;
		this.memberPrinter = memberPrinter;
	}
	public MemberListPrinter() {
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members) {
			memberPrinter.print(m);
		}
	}
}
