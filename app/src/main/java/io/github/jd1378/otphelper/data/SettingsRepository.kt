package io.github.jd1378.otphelper.data

import io.github.jd1378.otphelper.data.local.PreferenceDataStoreConstants
import io.github.jd1378.otphelper.data.local.PreferenceDataStoreHelper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsRepository
@Inject
constructor(private val preferenceDataStoreHelper: PreferenceDataStoreHelper) {

  fun getIsAutoCopyEnabledStream(): Flow<Boolean> {
    return preferenceDataStoreHelper.getPreference(
        PreferenceDataStoreConstants.IS_AUTO_COPY_ENABLED, false)
  }

  fun getIsPostNotifEnabledStream(): Flow<Boolean> {
    return preferenceDataStoreHelper.getPreference(
        PreferenceDataStoreConstants.IS_POST_NOTIF_ENABLED, true)
  }

  fun getIsSetupFinishedStream(): Flow<Boolean> {
    return preferenceDataStoreHelper.getPreference(
        PreferenceDataStoreConstants.IS_SETUP_FINISHED, false)
  }

  suspend fun getIsAutoCopyEnabled(): Boolean {
    return preferenceDataStoreHelper.getFirstPreference(
        PreferenceDataStoreConstants.IS_AUTO_COPY_ENABLED, false)
  }

  suspend fun getIsPostNotifEnabled(): Boolean {
    return preferenceDataStoreHelper.getFirstPreference(
        PreferenceDataStoreConstants.IS_POST_NOTIF_ENABLED, true)
  }

  suspend fun setIsAutoCopyEnabled(newValue: Boolean) {
    preferenceDataStoreHelper.putPreference(
        PreferenceDataStoreConstants.IS_AUTO_COPY_ENABLED, newValue)
  }
  suspend fun setIsPostNotifEnabled(newValue: Boolean) {
    preferenceDataStoreHelper.putPreference(
        PreferenceDataStoreConstants.IS_POST_NOTIF_ENABLED, newValue)
  }

  suspend fun setIsSetupFinished(newValue: Boolean) {
    preferenceDataStoreHelper.putPreference(
        PreferenceDataStoreConstants.IS_SETUP_FINISHED, newValue)
  }
}
