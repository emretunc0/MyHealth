package com.garmin.gh.apps.wellnessmonitor.service;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.garmin.gh.apps.wellnessmonitor.dao.LoadRequestTokenDao;
import com.garmin.gh.apps.wellnessmonitor.dao.UserAccessTokenDao;
import com.garmin.gh.apps.wellnessmonitor.dao.http.TokenProviderDao;
import com.garmin.gh.apps.wellnessmonitor.domain.RequestToken;
import com.garmin.gh.apps.wellnessmonitor.util.Consts;

@Service
@Component
public class OAuthService
{
    HttpServletResponse httpServletResponse;
   private static final Logger logger = LoggerFactory.getLogger(OAuthService.class);
    
    @Autowired
    TokenProviderDao tokenProvider;

    @Autowired
    LoadRequestTokenDao loadReqToken;

    @Autowired
    UserAccessTokenDao loadAccessToken;

    @Value("${oauthConfirm.url}")
    private String oauthConfirmUrl;

    @Value("${callBackURL.url}")
    private String callBackUrlValue;

    // It generates requesttoken and secret and save in the repository
    public RequestToken getRequestToken(String url, Long userId,
            String userName)
        {

            String reqTokenSecret = tokenProvider.generateRequestTokenSecret(url);
            if (reqTokenSecret.contains(Consts.OAUTH_TOKEN))
            {
                String[] tokenAndSecret = reqTokenSecret.split(Consts.VARIABLE_DELIMTER);
                String[] tokenValue = tokenAndSecret[0].split(Consts.VALUE_DELIMTER);
                String[] secretValue = tokenAndSecret[1].split(Consts.VALUE_DELIMTER);
                // storing generated requestToken ,requestTokenSecret for user. Here we implemented
                // in-memory database
                RequestToken reqToken = loadReqToken.saveRequestToken(userId, userName, tokenValue[1], secretValue[1]);
                return reqToken;
            }
            else
            {
                return null;
            }
        }

    public ResponseEntity<Object> oauthConfirm(String oauthAccessToken)
    {
        String oAuthConfirmURL = getOAuthConfirmURL(oauthConfirmUrl, oauthAccessToken);
        HttpHeaders httpHeaders = new HttpHeaders();
        try
        {
            URI uri = new URI(oAuthConfirmURL);
            httpHeaders.setLocation(uri);
        }
        catch (URISyntaxException e)
        {
            logger.error("URI syntax error:" + e.getMessage());
        }
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);

    }

    public String getOAuthConfirmURL(String confirmURL, String accessToken)
    {
        confirmURL = confirmURL + Consts.URL_DELIMTER + Consts.OAUTH_TOKEN + Consts.VALUE_DELIMTER + accessToken + Consts.VARIABLE_DELIMTER + Consts.CALLBACK_URL + '=' + callBackUrlValue;
        return confirmURL;

    }

    public void generateAccessToken(String url,String oauthTokenValue) 
    {

        String accessTokenSecret = tokenProvider.generateAccessTokenSecret(url, oauthTokenValue);
        if (accessTokenSecret.contains(Consts.OAUTH_TOKEN))
        {
            String[] tokenAndSecret = accessTokenSecret.split(Consts.VARIABLE_DELIMTER);
            String[] tokenValue = tokenAndSecret[0].split(Consts.VALUE_DELIMTER);
            String[] secretValue = tokenAndSecret[1].split(Consts.VALUE_DELIMTER);
            Long id = Long.parseLong(tokenAndSecret[2]);
            String name = tokenAndSecret[3];
            loadAccessToken.saveAccessToken(tokenValue[1], secretValue[1], id, name);

        }

    }

}