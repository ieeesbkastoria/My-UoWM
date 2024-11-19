import { useAuthContext } from './useAuthContext'
import { useLinksContext } from './useLinksContext'

export const useLogout = () => {
  const { dispatch } = useAuthContext()
  const { dispatch: dispatchLinks } = useLinksContext()

  const logout = () => {
    // remove user from storage
    localStorage.removeItem('user')

    // dispatch logout action
    dispatch({ type: 'LOGOUT' })
    dispatchLinks({ type: 'SET_LINKS', payload: null })
  }

  return { logout }
}
