from django.conf.urls import patterns, url

from workout import views

urlpatterns = patterns('',
    url(r'^workouts/$', views.WorkoutIndexView.as_view(), name='workoutindex'),
    url(r'^workouts/(?P<pk>\d+)/$', views.WorkoutDetailView.as_view(), name='workoutdetail'),
    url(r'workouts/add/$', views.WorkoutCreate.as_view(), name='workout_add'),
    url(r'workouts/analysis/', views.analysis, name='workoutanalysis'),
    url(r'^workoutplans/$', views.WorkoutPlanIndexView.as_view(), name='workoutplanindex'),
    url(r'^workoutplans/(?P<pk>\d+)/$', views.WorkoutPlanDetailView.as_view(), name='workoutplandetail'),
)
