package login.test.automation;

import org.openqa.selenium.By;

public class LoginPage extends PageObject{

    private static final String URL_INICIAL= "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    public LoginPage (){
        super(null);
        this.browser.navigate().to(URL_INICIAL);
    }

    public void preencheEmail(String email) {
        browser.findElement(By.id("email")).sendKeys(email);
    }

    public void preencheSenha(String senha) {
        browser.findElement(By.id("passwd")).sendKeys(senha);
    }

    public boolean isPaginaDeAcesso() {
        return browser.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account");
    }

    public void efetuarLogin() {
        browser.findElement(By.id("SubmitLogin")).click();
    }

    public boolean isMensagemDeAutenticacao() {
        return browser.getPageSource().contains("Jhonata Moreira");
    }

    public boolean isMensagemDeErro() {
        return browser.getPageSource().contains("There is 1 error");
    }

    public boolean isMensagemDeCamposVazios() {
        return browser.getPageSource().contains("An email address required.");
    }

    public boolean isPaginaDeLogin() {
        return browser.getCurrentUrl().equals(URL_INICIAL);
    }

    public boolean isPaginaDeLoginComErro() {
        return browser.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication");
    }
}
