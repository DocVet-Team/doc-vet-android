package com.example.docvet;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Rule;
import org.junit.Test;

public class CadastroActivityTest {

    @Rule
    public ActivityScenarioRule<CadastroActivity> activityRule = new ActivityScenarioRule<>(CadastroActivity.class);

    @Test
    public void testCadastroActivity() {
        // Teste para verificar se os elementos estão presentes
        Espresso.onView(ViewMatchers.withId(R.id.edtNomeDonoPet)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.edtEmail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.edtCpf)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.edtTelefone)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.edtSenhaDonoPet)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.edtConfSenha)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.btnCadastrarDonoDePet)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        // Teste para preenchimento dos campos
        Espresso.onView(ViewMatchers.withId(R.id.edtNomeDonoPet)).perform(ViewActions.typeText("Nome do Pet"));
        Espresso.onView(ViewMatchers.withId(R.id.edtEmail)).perform(ViewActions.typeText("usuario@example.com"));
        Espresso.onView(ViewMatchers.withId(R.id.edtCpf)).perform(ViewActions.typeText("12345678901"));
        Espresso.onView(ViewMatchers.withId(R.id.edtTelefone)).perform(ViewActions.typeText("123456789"));
        Espresso.onView(ViewMatchers.withId(R.id.edtSenhaDonoPet)).perform(ViewActions.typeText("senha123"));
        Espresso.onView(ViewMatchers.withId(R.id.edtConfSenha)).perform(ViewActions.typeText("senha123"));

        // Teste para clicar no botão de cadastrar
        Espresso.onView(ViewMatchers.withId(R.id.btnCadastrarDonoDePet)).perform(ViewActions.click());

        // Adicione mais testes conforme necessário para verificar o comportamento desejado
    }
}

