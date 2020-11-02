# Wildcard Subdomain Ktor CORS Feature

Dette biblioteket tilbyr en ktor-feature med en alternativ implementasjon av deres CORS modul.
Denne tillater å sette subdomains til `*`. 

Endringene fra ktors egen CORS modul påvirker kun hvorvidtappen selv svarer med feilkode 403 på et cors-kall.

Eksempel-config for å godta kall fra alle subdomener på `nav.no`:

```kotlin
install(NonStandardCORS) {
    host(
        host = "nav.no", 
        schemes = listOf("https"), 
        subDomains = listOf("*")
    )
}
```

Biblioteket finnes på jitpack [her](https://jitpack.io/#navikt/wildcard-subdomain-ktor-cors-feature).