
package ws.usuario;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.usuario package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddPersona_QNAME = new QName("http://controller/", "addPersona");
    private final static QName _AddPersonaResponse_QNAME = new QName("http://controller/", "addPersonaResponse");
    private final static QName _GetPersona_QNAME = new QName("http://controller/", "getPersona");
    private final static QName _GetPersonaResponse_QNAME = new QName("http://controller/", "getPersonaResponse");
    private final static QName _GetPersonas_QNAME = new QName("http://controller/", "getPersonas");
    private final static QName _GetPersonasResponse_QNAME = new QName("http://controller/", "getPersonasResponse");
    private final static QName _GetSaldo_QNAME = new QName("http://controller/", "getSaldo");
    private final static QName _GetSaldoResponse_QNAME = new QName("http://controller/", "getSaldoResponse");
    private final static QName _UpdateSaldo_QNAME = new QName("http://controller/", "updateSaldo");
    private final static QName _UpdateSaldoResponse_QNAME = new QName("http://controller/", "updateSaldoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.usuario
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddPersona }
     * 
     */
    public AddPersona createAddPersona() {
        return new AddPersona();
    }

    /**
     * Create an instance of {@link AddPersonaResponse }
     * 
     */
    public AddPersonaResponse createAddPersonaResponse() {
        return new AddPersonaResponse();
    }

    /**
     * Create an instance of {@link GetPersona }
     * 
     */
    public GetPersona createGetPersona() {
        return new GetPersona();
    }

    /**
     * Create an instance of {@link GetPersonaResponse }
     * 
     */
    public GetPersonaResponse createGetPersonaResponse() {
        return new GetPersonaResponse();
    }

    /**
     * Create an instance of {@link GetPersonas }
     * 
     */
    public GetPersonas createGetPersonas() {
        return new GetPersonas();
    }

    /**
     * Create an instance of {@link GetPersonasResponse }
     * 
     */
    public GetPersonasResponse createGetPersonasResponse() {
        return new GetPersonasResponse();
    }

    /**
     * Create an instance of {@link GetSaldo }
     * 
     */
    public GetSaldo createGetSaldo() {
        return new GetSaldo();
    }

    /**
     * Create an instance of {@link GetSaldoResponse }
     * 
     */
    public GetSaldoResponse createGetSaldoResponse() {
        return new GetSaldoResponse();
    }

    /**
     * Create an instance of {@link UpdateSaldo }
     * 
     */
    public UpdateSaldo createUpdateSaldo() {
        return new UpdateSaldo();
    }

    /**
     * Create an instance of {@link UpdateSaldoResponse }
     * 
     */
    public UpdateSaldoResponse createUpdateSaldoResponse() {
        return new UpdateSaldoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersona }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddPersona }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller/", name = "addPersona")
    public JAXBElement<AddPersona> createAddPersona(AddPersona value) {
        return new JAXBElement<AddPersona>(_AddPersona_QNAME, AddPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersonaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddPersonaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller/", name = "addPersonaResponse")
    public JAXBElement<AddPersonaResponse> createAddPersonaResponse(AddPersonaResponse value) {
        return new JAXBElement<AddPersonaResponse>(_AddPersonaResponse_QNAME, AddPersonaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersona }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersona }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller/", name = "getPersona")
    public JAXBElement<GetPersona> createGetPersona(GetPersona value) {
        return new JAXBElement<GetPersona>(_GetPersona_QNAME, GetPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersonaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller/", name = "getPersonaResponse")
    public JAXBElement<GetPersonaResponse> createGetPersonaResponse(GetPersonaResponse value) {
        return new JAXBElement<GetPersonaResponse>(_GetPersonaResponse_QNAME, GetPersonaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonas }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersonas }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller/", name = "getPersonas")
    public JAXBElement<GetPersonas> createGetPersonas(GetPersonas value) {
        return new JAXBElement<GetPersonas>(_GetPersonas_QNAME, GetPersonas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonasResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersonasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller/", name = "getPersonasResponse")
    public JAXBElement<GetPersonasResponse> createGetPersonasResponse(GetPersonasResponse value) {
        return new JAXBElement<GetPersonasResponse>(_GetPersonasResponse_QNAME, GetPersonasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSaldo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSaldo }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller/", name = "getSaldo")
    public JAXBElement<GetSaldo> createGetSaldo(GetSaldo value) {
        return new JAXBElement<GetSaldo>(_GetSaldo_QNAME, GetSaldo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSaldoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSaldoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller/", name = "getSaldoResponse")
    public JAXBElement<GetSaldoResponse> createGetSaldoResponse(GetSaldoResponse value) {
        return new JAXBElement<GetSaldoResponse>(_GetSaldoResponse_QNAME, GetSaldoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSaldo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateSaldo }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller/", name = "updateSaldo")
    public JAXBElement<UpdateSaldo> createUpdateSaldo(UpdateSaldo value) {
        return new JAXBElement<UpdateSaldo>(_UpdateSaldo_QNAME, UpdateSaldo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSaldoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateSaldoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller/", name = "updateSaldoResponse")
    public JAXBElement<UpdateSaldoResponse> createUpdateSaldoResponse(UpdateSaldoResponse value) {
        return new JAXBElement<UpdateSaldoResponse>(_UpdateSaldoResponse_QNAME, UpdateSaldoResponse.class, null, value);
    }

}
