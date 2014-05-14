from django.db import models
from profiles.models import CoachingUser
from django.core.urlresolvers import reverse

class Weight(models.Model):
    '''stores an athlete weight tracked over time'''
    date = models.DateField()
    weight = models.IntegerField()
    comment = models.CharField(max_length=200, blank=True)
    runner = models.ForeignKey(CoachingUser, null = True)
    def __str__(self):
        return date + " " + weight
    def get_absolute_url(self):
        return reverse('weightlist')

