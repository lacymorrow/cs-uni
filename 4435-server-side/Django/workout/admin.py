from django.contrib import admin
from workout.models import WorkoutType, RunningSurface, CourseType, WorkoutPlan, Workout

admin.site.register(WorkoutType)
admin.site.register(RunningSurface)
admin.site.register(CourseType)
admin.site.register(WorkoutPlan)
admin.site.register(Workout)
