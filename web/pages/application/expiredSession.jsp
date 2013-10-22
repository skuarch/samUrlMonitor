<%@taglib prefix="s" uri="/struts-tags" %>
<s:property value="getText('global.session.expired')" />
<a class="btn btn-success" href="login">
    <s:property value="getText('login.submit')"/>
</a>