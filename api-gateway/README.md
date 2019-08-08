API GATEWAY PATTERN
The api-gateway application acts the router and authentication and authorization endpoint.
The Zuul api gateway solves a very common use case where a UI application wants to proxy calls to one or more back end services. This feature is useful for a user interface to proxy to the backend services it requires, avoiding the need to manage CORS and authentication concerns independently for all the backends.For example in our application /track-service/** endpoint is mapped to the track-service.
It also knows how to invoke the authorization server in case the track is not authenticated. Once the authentication is complete, it relays the OAuth2 token to the respective services so that they can find the authenticated track and provide services.



THIS IS API-GATEWAY-PATTERN FOR TRACK_SERVICE