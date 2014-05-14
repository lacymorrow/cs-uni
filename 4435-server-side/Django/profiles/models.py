from django.db import models
from django.conf import settings
from django.core.urlresolvers import reverse
from django.contrib.auth.models import AbstractUser
from django.utils.translation import ugettext_lazy as _

class CoachingUser(AbstractUser):
    USER_TYPE_CHOICES = (
        ('C', 'Coach'),
        ('R', 'Runner'),
    )
    GENDER_TYPE_CHOICES = (
    	('M', 'Male'),
    	('F', 'Female'),
    )
    user_type = models.CharField(max_length=30, choices=USER_TYPE_CHOICES, default='R')
    coach = models.ForeignKey(settings.AUTH_USER_MODEL, null=True, blank = True)
    gender = models.CharField(max_length=30, choices=GENDER_TYPE_CHOICES, default='M')
    birth_date = models.DateField(blank=False, null=True)
    coaching = models.PositiveIntegerField(_("coaching"), default = 0, blank = True)