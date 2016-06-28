package sujetos;

public class GeneracionDeSujetos {
    public static String genereElSujeto(String laIdentificacion,
                                        TipoDeIdentificacion elTipoDeIdentificacion,
                                        String elNombre,
                                        String elPrimerApellido,
                                        String elSegundoApellido,
                                        TipoDeCertificado elTipoDeCertificado) {
        String elNombreEnMayuscula = conviertaAMayusculas(elNombre);
        String losApellidosFormateados = obtengaLosApellidosFormateados(elPrimerApellido, elSegundoApellido);

        return obtengaElSujetoFormateado(laIdentificacion, elTipoDeIdentificacion, elTipoDeCertificado, elNombreEnMayuscula, losApellidosFormateados);
    }

    private static String obtengaElSujetoFormateado(String laIdentificacion, TipoDeIdentificacion elTipoDeIdentificacion, TipoDeCertificado elTipoDeCertificado, String elNombreEnMayuscula, String losApellidosFormateados) {
        String elCN = obtengaElCN(elTipoDeCertificado, elNombreEnMayuscula, losApellidosFormateados);
        String elOU = obtengaElOU(elTipoDeIdentificacion);
        String elO = obtengaElO();
        String elC = obtengaElC();
        String elGivenName = obtengaElGivenName(elNombreEnMayuscula);
        String elSurName = obtengaElSurName(losApellidosFormateados);
        String elSerialNumber = obtengaElSerialNumber(laIdentificacion, elTipoDeIdentificacion);

        return formateeElSujeto(elCN, elOU, elO, elC, elGivenName, elSurName, elSerialNumber);
    }

    private static String obtengaElCN(TipoDeCertificado elTipoDeCertificado, String elNombreEnMayuscula, String losApellidosFormateados) {
        String elProposito = determineElProposito(elTipoDeCertificado);
        return formateeElCN(elNombreEnMayuscula, losApellidosFormateados, elProposito);
    }

    private static String obtengaLosApellidosFormateados(String elPrimerApellido, String elSegundoApellido) {
        String losApellidos = obtengaLosApellidos(elPrimerApellido, elSegundoApellido);
        String losApellidosEnMayusculas = conviertaAMayusculas(losApellidos);

        return formateeLosApellidos(losApellidosEnMayusculas);
    }

    private static String obtengaElOU(TipoDeIdentificacion elTipoDeIdentificacion) {
        if (EsNacional(elTipoDeIdentificacion))
            return obtengaElOUNacional();
        else
            return obtengaElOUExtranjero();
    }

    private static boolean EsNacional(TipoDeIdentificacion elTipoDeIdentificacion) {
        return elTipoDeIdentificacion == TipoDeIdentificacion.Cedula;
    }

    private static String obtengaElOUNacional() {
        return "OU=CIUDADANO";
    }

    private static String obtengaElOUExtranjero() {
        return "OU=EXTRANJERO";
    }

    private static String obtengaElO() {
        return "O=PERSONA FISICA";
    }

    private static String obtengaElC() {
        return "C=CR";
    }

    private static String obtengaElGivenName(String elNombreEnMayuscula) {
        return "GivenName=" + elNombreEnMayuscula;
    }

    private static String obtengaElSurName(String losApellidosFormateados) {
        return "Surname=" + losApellidosFormateados;
    }

    private static String obtengaElSerialNumber(String laIdentificacion, TipoDeIdentificacion elTipoDeIdentificacion) {
        if (EsNacional(elTipoDeIdentificacion))
            return "SERIALNUMBER=CPF-" + laIdentificacion;
        else
            return "SERIALNUMBER=NUP-" + laIdentificacion;
    }

    private static String formateeElCN(String elNombreEnMayuscula, String losApellidosFormateados, String elProposito) {
        return "CN=" + elNombreEnMayuscula + " " + losApellidosFormateados + " " + "(" + elProposito + ")";
    }

    private static String determineElProposito(TipoDeCertificado elTipoDeCertificado) {
        if (esDeAutenticacion(elTipoDeCertificado))
            return obtengaElPropositoDeAutenticacion();
        else
            return obtengaElPropositoDeFirma();
    }

    private static boolean esDeAutenticacion(TipoDeCertificado elTipoDeCertificado) {
        return elTipoDeCertificado == TipoDeCertificado.Autenticacion;
    }

    private static String obtengaElPropositoDeAutenticacion() {
        return "AUTENTICACION";
    }

    private static String obtengaElPropositoDeFirma() {
        return "FIRMA";
    }

    private static String formateeLosApellidos(String losApellidosEnMayusculas) {
        return losApellidosEnMayusculas.trim();
    }

    private static String obtengaLosApellidos(String elPrimerApellido, String elSegundoApellido) {
        return elPrimerApellido + " " + elSegundoApellido;
    }

    private static String conviertaAMayusculas(String elNombre) {
        return elNombre.toUpperCase();
    }

    private static String formateeElSujeto(String elCN, String elOU, String elO, String elC, String elGivenName, String elSurName, String elSerialNumber) {
        return elCN + ", " + elOU + ", " + elO + ", " + elC + ", " + elGivenName + ", " + elSurName + ", " + elSerialNumber;
    }
}
