package login.test.automation;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach(){
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach(){
        this.paginaDeLogin.fechar();
    }

    @Test
    public void loginFunciona(){
        this.paginaDeLogin.preencheEmail("jhonata.filizola@gmail.com");
        this.paginaDeLogin.preencheSenha("pass123456");
        this.paginaDeLogin.efetuarLogin();

        Assert.assertTrue(paginaDeLogin.isPaginaDeAcesso());
        Assert.assertTrue(paginaDeLogin.isMensagemDeAutenticacao());
        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
    }

    @Test
    public void loginComSenhaIncorreta(){
        this.paginaDeLogin.preencheEmail("jhonata.filizola@gmail.com");
        this.paginaDeLogin.preencheSenha("pass123");
        this.paginaDeLogin.efetuarLogin();

        Assert.assertFalse(paginaDeLogin.isPaginaDeAcesso());
        Assert.assertTrue(paginaDeLogin.isMensagemDeErro());
        Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComErro());
    }

    @Test
    public void loginEmBranco(){
        this.paginaDeLogin.preencheEmail("");
        this.paginaDeLogin.preencheSenha("");
        this.paginaDeLogin.efetuarLogin();

        Assert.assertFalse(paginaDeLogin.isPaginaDeAcesso());
        Assert.assertTrue(paginaDeLogin.isMensagemDeCamposVazios());
        Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComErro());
    }

    @Test
    public void loginComEmailNaoCadastrado(){
        this.paginaDeLogin.preencheEmail("jhonata.moreira@gmail.com");
        this.paginaDeLogin.preencheSenha("pass123456");
        this.paginaDeLogin.efetuarLogin();

        Assert.assertFalse(paginaDeLogin.isPaginaDeAcesso());
        Assert.assertTrue(paginaDeLogin.isMensagemDeErro());
        Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComErro());
    }
}
