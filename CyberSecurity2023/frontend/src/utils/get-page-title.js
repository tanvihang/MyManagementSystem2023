import defaultSettings from '@/settings'

const title = '啊吧管理系统'

export default function getPageTitle(pageTitle) {
  if (pageTitle) {
    return ` ${title} - ${pageTitle}`
  }
  return `${title}`
}
