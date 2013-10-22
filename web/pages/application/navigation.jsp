<%@taglib prefix="s" uri="/struts-tags"%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">
            <s:property value="getText('application.brand')" />
        </a>
        <div class="nav-collapse collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="dashboard">
                        <s:property value="getText('navigation.link.1')" />
                    </a>
                </li>
                <li>
                    <a href="taskScheduler">
                        <s:property value="getText('navigation.link.2')" />
                    </a>
                </li>
                <li>
                    <a href="logout">
                        <s:property value="getText('navigation.link.3')" />
                    </a>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>