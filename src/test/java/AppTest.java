import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.article.ArticleDto;
import org.example.util.Ut;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
  @Test
  void 실험_assertThat() {
    int rs = 10 + 20;
    assertThat(rs).isEqualTo(30);
  }

  @Test
  void 실험_ObjectMapper() throws JsonProcessingException {
    ArticleDto articleDto = new ArticleDto(1, "제목1", "내용1");

    /*
    ObjectMapper om = new ObjectMapper();

    String jsonStr = om.writeValueAsString(articleDto);
    System.out.println(jsonStr);
    */

    String jsonStr = Ut.json.toJsonStr(articleDto, "");
    System.out.println(jsonStr);

    // isNotBlank() : 빈 문자열이 아니다.
    assertThat(jsonStr).isNotBlank();

    // json화 한 데이터가 밑에 있는 결과랑 같아야 한다.
    assertThat(jsonStr).isEqualTo("""
        {"id":1,"subject":"제목1","content":"내용1"}
        """.trim());
  }
}
