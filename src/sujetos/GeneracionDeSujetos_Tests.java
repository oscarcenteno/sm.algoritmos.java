package sujetos;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GeneracionDeSujetos_Tests {
    private String elNombre;
    private String elPrimerApellido;
    private String elResultadoEsperado;
    private String elResultadoObtenido;
    private String elSegundoApellido;
    private TipoDeIdentificacion elTipDeIdentificacion;
    private TipoDeCertificado elTipoDeCertificado;
    private String laIdentificacion;

    @Test
    public void genereUnSujeto_AutenticacionParaUnaPersonaNacional_PropositoOUYSerialCorrectos() throws Exception {
        elResultadoEsperado = "CN=MARCELINO NAVARRO QUIROS (AUTENTICACION), OU=CIUDADANO, O=PERSONA FISICA, C=CR, GivenName=MARCELINO, Surname=NAVARRO QUIROS, SERIALNUMBER=CPF-01-0078-5935";

        laIdentificacion = "01-0078-5935";
        elTipDeIdentificacion = TipoDeIdentificacion.Cedula;
        elNombre = "Marcelino";
        elPrimerApellido = "Navarro";
        elSegundoApellido = "Quiros";
        elTipoDeCertificado = TipoDeCertificado.Autenticacion;
        elResultadoObtenido = GeneracionDeSujetos.genereElSujeto(laIdentificacion,
                elTipDeIdentificacion,
                elNombre,
                elPrimerApellido,
                elSegundoApellido,
                elTipoDeCertificado
        );

        assertEquals(elResultadoEsperado, elResultadoObtenido);
    }

    @Test
    public void genereUnSujeto_FirmaParaUnaPersonaNacional_PropositoOUYSerialCorrectos() throws Exception {
        elResultadoEsperado = "CN=MARCELINO NAVARRO QUIROS (FIRMA), OU=CIUDADANO, O=PERSONA FISICA, C=CR, GivenName=MARCELINO, Surname=NAVARRO QUIROS, SERIALNUMBER=CPF-01-0078-5935";

        laIdentificacion = "01-0078-5935";
        elTipDeIdentificacion = TipoDeIdentificacion.Cedula;
        elNombre = "Marcelino";
        elPrimerApellido = "Navarro";
        elSegundoApellido = "Quiros";
        elTipoDeCertificado = TipoDeCertificado.Firma;
        elResultadoObtenido = GeneracionDeSujetos.genereElSujeto(laIdentificacion,
                elTipDeIdentificacion,
                elNombre,
                elPrimerApellido,
                elSegundoApellido,
                elTipoDeCertificado
        );

        assertEquals(elResultadoEsperado, elResultadoObtenido);
    }

    @Test
    public void genereUnSujeto_AutenticacionParaUnaPersonaExtranjera_PropositoOUYSerialCorrectos() throws Exception {
        elResultadoEsperado = "CN=JOSE MIGUEL SUAREZ GODINEZ (AUTENTICACION), OU=EXTRANJERO, O=PERSONA FISICA, C=CR, GivenName=JOSE MIGUEL, Surname=SUAREZ GODINEZ, SERIALNUMBER=NUP-114145540011";

        laIdentificacion = "114145540011";
        elTipDeIdentificacion = TipoDeIdentificacion.Dimex;
        elNombre = "Jose Miguel";
        elPrimerApellido = "Suarez";
        elSegundoApellido = "Godinez";
        elTipoDeCertificado = TipoDeCertificado.Autenticacion;
        elResultadoObtenido = GeneracionDeSujetos.genereElSujeto(laIdentificacion,
                elTipDeIdentificacion,
                elNombre,
                elPrimerApellido,
                elSegundoApellido,
                elTipoDeCertificado
        );

        assertEquals(elResultadoEsperado, elResultadoObtenido);
    }

    @Test
    public void genereUnSujeto_FirmaaraUnaPersonaExtranjera_PropositoOUYSerialCorrectos() throws Exception {
        elResultadoEsperado = "CN=JOSE MIGUEL SUAREZ GODINEZ (FIRMA), OU=EXTRANJERO, O=PERSONA FISICA, C=CR, GivenName=JOSE MIGUEL, Surname=SUAREZ GODINEZ, SERIALNUMBER=NUP-114145540011";

        laIdentificacion = "114145540011";
        elTipDeIdentificacion = TipoDeIdentificacion.Dimex;
        elNombre = "Jose Miguel";
        elPrimerApellido = "Suarez";
        elSegundoApellido = "Godinez";
        elTipoDeCertificado = TipoDeCertificado.Firma;
        elResultadoObtenido = GeneracionDeSujetos.genereElSujeto(laIdentificacion,
                elTipDeIdentificacion,
                elNombre,
                elPrimerApellido,
                elSegundoApellido,
                elTipoDeCertificado
        );

        assertEquals(elResultadoEsperado, elResultadoObtenido);
    }

    @Test
    public void genereUnSujeto_AutenticacionParaUnaPersonaExtranjeraConUnSoloApellido_ApellidosBienFormateados() throws Exception {
        elResultadoEsperado = "CN=JOHN SMITH (AUTENTICACION), OU=EXTRANJERO, O=PERSONA FISICA, C=CR, GivenName=JOHN, Surname=SMITH, SERIALNUMBER=NUP-114145540011";

        laIdentificacion = "114145540011";
        elTipDeIdentificacion = TipoDeIdentificacion.Didi;
        elNombre = "John";
        elPrimerApellido = "Smith";
        elSegundoApellido = "";
        elTipoDeCertificado = TipoDeCertificado.Autenticacion;
        elResultadoObtenido = GeneracionDeSujetos.genereElSujeto(laIdentificacion,
                elTipDeIdentificacion,
                elNombre,
                elPrimerApellido,
                elSegundoApellido,
                elTipoDeCertificado
        );

        assertEquals(elResultadoEsperado, elResultadoObtenido);
    }

    @Test
    public void genereUnSujeto_FirmaParaUnaPersonaExtranjeraConUnSoloApellido_ApellidosBienFormateados() throws Exception {
        elResultadoEsperado = "CN=JOHN SMITH (FIRMA), OU=EXTRANJERO, O=PERSONA FISICA, C=CR, GivenName=JOHN, Surname=SMITH, SERIALNUMBER=NUP-114145540011";

        laIdentificacion = "114145540011";
        elTipDeIdentificacion = TipoDeIdentificacion.Didi;
        elNombre = "John";
        elPrimerApellido = "Smith";
        elSegundoApellido = "";
        elTipoDeCertificado = TipoDeCertificado.Firma;
        elResultadoObtenido = GeneracionDeSujetos.genereElSujeto(laIdentificacion,
                elTipDeIdentificacion,
                elNombre,
                elPrimerApellido,
                elSegundoApellido,
                elTipoDeCertificado
        );

        assertEquals(elResultadoEsperado, elResultadoObtenido);
    }
}
