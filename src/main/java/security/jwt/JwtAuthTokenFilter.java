//package security.jwt;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//public class JwtAuthTokenFilter implements HandlerInterceptor {
//
//	@Override
//    protected void prehandle(HttpServletRequest request, HttpServletResponse response)  {
//  
//            String jwt = getJwt(request);
//            System.out.println("==========JWT FROM FILTER=========" + jwt);
////            if (jwt!=null && tokenProvider.validateJwtToken(jwt)) {
////                String username = tokenProvider.getUserNameFromJwtToken(jwt);
////
////                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
////                UsernamePasswordAuthenticationToken authentication 
////                		= new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
////                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
////
////                SecurityContextHolder.getContext().setAuthentication(authentication);
////            }
//
//    }
//	
//    private String getJwt(HttpServletRequest request) {
//        String authHeader = request.getHeader("Authorization");
//        System.out.println(authHeader);
//        	
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//        	return authHeader.replace("Bearer ","");
//        }
//
//        return null;
//    }
//}
