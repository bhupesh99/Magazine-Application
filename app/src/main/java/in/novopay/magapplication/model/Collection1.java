
package in.novopay.magapplication.model;

import com.google.gson.annotations.Expose;

public class Collection1 {

    @Expose
    private Magazinename magazinename;
    @Expose
    private Magazinephoto magazinephoto;
    @Expose
    private String magazinedesc;
    @Expose
    private Integer index;
    @Expose
    private String url;

    /**
     * 
     * @return
     *     The magazinename
     */
    public Magazinename getMagazinename() {
        return magazinename;
    }

    /**
     * 
     * @param magazinename
     *     The magazinename
     */
    public void setMagazinename(Magazinename magazinename) {
        this.magazinename = magazinename;
    }

    /**
     * 
     * @return
     *     The magazinephoto
     */
    public Magazinephoto getMagazinephoto() {
        return magazinephoto;
    }

    /**
     * 
     * @param magazinephoto
     *     The magazinephoto
     */
    public void setMagazinephoto(Magazinephoto magazinephoto) {
        this.magazinephoto = magazinephoto;
    }

    /**
     * 
     * @return
     *     The magazinedesc
     */
    public String getMagazinedesc() {
        return magazinedesc;
    }

    /**
     * 
     * @param magazinedesc
     *     The magazinedesc
     */
    public void setMagazinedesc(String magazinedesc) {
        this.magazinedesc = magazinedesc;
    }

    /**
     * 
     * @return
     *     The index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * 
     * @param index
     *     The index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
