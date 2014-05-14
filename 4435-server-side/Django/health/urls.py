from django.conf.urls import patterns, url

from health import views

urlpatterns = patterns('',
    url(r'^weight/list/$', views.WeightList.as_view(), name='weightlist'),
    url(r'^weight/add/$', views.WeightAdd.as_view(), name='weightadd'),
)

