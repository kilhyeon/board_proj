package board_proj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.dto.ActionForward;
import board_proj.dto.BoardDTO;
import board_proj.service.BoardReplyProService;

public class BoardReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) /* throws Exception */ {
		int page = Integer.parseInt(request.getParameter("page"));
		BoardDTO article = getArticle(request);
//		System.out.println("article >> " + article);

		BoardReplyProService service = new BoardReplyProService();
		boolean res = service.replyArticle(article);

		ActionForward forward = null;
		if (res) {
			forward = new ActionForward("boardList.do?page=" + page, true);
		} else {
			SendMessage.sendMessage(response, "답변 등록 실패");
		}

		return forward;
	}

	private BoardDTO getArticle(HttpServletRequest request) {

		int BOARD_NUM = Integer.parseInt(request.getParameter("BOARD_NUM"));
		int BOARD_RE_REF = Integer.parseInt(request.getParameter("BOARD_RE_REF"));
		int BOARD_RE_LEV = Integer.parseInt(request.getParameter("BOARD_RE_LEV"));
		int BOARD_RE_SEQ = Integer.parseInt(request.getParameter("BOARD_RE_SEQ"));

		String BOARD_NAME = request.getParameter("BOARD_NAME");
		String BOARD_PASS = request.getParameter("BOARD_PASS");
		String BOARD_SUBJECT = request.getParameter("BOARD_SUBJECT");
		String BOARD_CONTENT = request.getParameter("BOARD_CONTENT");

		return new BoardDTO(BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT, "", BOARD_RE_REF,
				BOARD_RE_LEV, BOARD_RE_SEQ, 0, null);
	}

}
